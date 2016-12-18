var gulp=require("gulp")
var tsc=require("gulp-typescript")
var connect=require("gulp-connect")
var destination="dist_client"
var src="client-angular"
var del=require("del")

var tsProject=tsc.createProject("tsconfig.json")

gulp.task("compilation",function(){
    var tsResult= gulp.src(src+"/**/*.ts")
    .pipe(tsProject())
    
    return tsResult.js.pipe(gulp.dest(destination))

})

gulp.task("lib",function(){
    return gulp.src(["node_modules/core-js/client/shim.min.js","node_modules/zone.js/dist/zone.js",
                        "node_modules/reflect-metadata/Reflect.js","node_modules/systemjs/dist/system.src.js"
    
    ])
    .pipe(gulp.dest(destination+"/lib/"))
})
gulp.task("static",function(){
    return gulp.src([src+"/systemjs.config.js",src+"/**/*.html",src+"/**/*.css"]).pipe(gulp.dest(destination))
})

gulp.task("node_modules",function(){
    return gulp.src(["node_modules/@angular/**","node_modules/rxjs/**","node_modules/angular-in-memory-web-api/**"],{base:'.'}).pipe(gulp.dest(destination))
})

gulp.task("clean",function(){
    del(destination+"/**")
})

gulp.task('server', function() {
  connect.server({
    root: 'dist_client/',
    host: 'localhost',
    port: 3000,
    livereload: {
      port: 35929
    }
  })
})
gulp.task("default",["clean","node_modules","compilation","lib","static"])