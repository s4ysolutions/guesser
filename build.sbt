import org.scalajs.linker.interface.ModuleSplitStyle

lazy val guesser = project.in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    scalaVersion := "3.6.2",
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(
          ModuleSplitStyle.SmallModulesFor(List("guesser")))
    },
    libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.8.0",
    libraryDependencies += "com.raquo" %%% "laminar" % "17.2.0",
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.3" % Test
  )