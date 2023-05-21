const gulp = require('gulp');
const sass = require('gulp-sass');
const concat = require('gulp-concat');
const uglify = require('gulp-uglify');
const cleanCSS = require('gulp-clean-css');
const imagemin = require('gulp-imagemin');
const browserSync = require('browser-sync').create();

// Tarea para compilar Sass a CSS
gulp.task('sass', function () {
    return gulp
        .src('src/sass/**/*.scss')
        .pipe(sass())
        .pipe(gulp.dest('dist/css'))
        .pipe(browserSync.stream());
});

// Tarea para concatenar y minificar archivos CSS
gulp.task('styles', function () {
    return gulp
        .src('dist/css/**/*.css')
        .pipe(concat('main.css'))
        .pipe(cleanCSS())
        .pipe(gulp.dest('dist/css'))
        .pipe(browserSync.stream());
});



// Tarea para optimizar imágenes
gulp.task('images', function () {
    return gulp
        .src('src/images/**/*')
        .pipe(imagemin())
        .pipe(gulp.dest('dist/images'))
        .pipe(browserSync.stream());
});

// Tarea para iniciar el servidor de desarrollo y recarga en vivo
gulp.task('serve', function () {
    browserSync.init({
        server: {
            baseDir: './dist',
        },
    });

    gulp.watch('src/sass/**/*.scss', gulp.series('sass', 'styles'));
    gulp.watch('src/js/**/*.js', gulp.series('scripts'));
    gulp.watch('src/images/**/*', gulp.series('images'));
    gulp.watch('dist/**/*.html').on('change', browserSync.reload);
});

// Tarea por defecto que ejecuta todas las tareas
gulp.task('default', gulp.series('sass', 'styles', 'scripts', 'images', 'serve'));
