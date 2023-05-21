const gulp = require('gulp');
const sass = require('gulp-sass');
const shell = require('gulp-shell');
const concat = require('gulp-concat');
const cleanCSS = require('gulp-clean-css');
const imagemin = require('gulp-imagemin');
const browserSync = require('browser-sync').create();

// Tarea para compilar Sass a CSS
task('sass', function () {
    return gulp
        .src('src/sass/**/*.scss')
        .pipe(sass())
        .pipe(dest('dist/css'))
        .pipe(browserSync.stream());
});

// Tarea para concatenar y minificar archivos CSS
task('styles', function () {
    return gulp
        .src('dist/css/**/*.css')
        .pipe(concat('common.css'))
        .pipe(cleanCSS())
        .pipe(dest('dist/css'))
        .pipe(browserSync.stream());
});



// Tarea para optimizar imágenes
task('images', function () {
    return gulp
        .src('src/images/**/*')
        .pipe(imagemin())
        .pipe(dest('dist/images'))
        .pipe(browserSync.stream());
});

// Tarea para iniciar el servidor de desarrollo y recarga en vivo
task('serve', function () {
    browserSync.init({
        server: {
            baseDir: './dist',
        },
    });

    watch('src/sass/**/*.scss',series('sass', 'styles'));
    watch('src/images/**/*', series('images'));
    watch('dist/**/*.html').on('change', browserSync.reload);
});
//tarea para ejecutar el comando de spring-boot

task('run', shell.task('./mvnw spring-boot:run'));

// Tarea por defecto que ejecuta todas las tareas
task('default', series('sass', 'styles', 'scripts', 'images', 'serve'));

exports.default = gulp.series('run');
