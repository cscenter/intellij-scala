package org.jetbrains.plugins.scala
package compiler

import com.intellij.openapi.project.Project
import com.intellij.openapi.components.ProjectComponent
import config.ScalaFacet
import com.intellij.compiler.CompilerWorkspaceConfiguration
import com.intellij.openapi.compiler.{CompileContext, CompileTask, CompilerManager}

/**
 * Pavel Fatin
 */

class ServerMediator(project: Project) extends ProjectComponent {
  CompilerManager.getInstance(project).addBeforeTask(new CompileTask {
    def execute(context: CompileContext): Boolean = {
      val scalaProject = ScalaFacet.isPresentIn(project)

      val externalCompiler = CompilerWorkspaceConfiguration.getInstance(project).USE_COMPILE_SERVER

      if (scalaProject) {
        if (externalCompiler) {
          project.getComponent(classOf[FscServerLauncher]).stop()
          project.getComponent(classOf[FscServerManager]).removeWidget()

          val applicationSettings = ScalaApplicationSettings.getInstance()

          if (applicationSettings.COMPILE_SERVER_ENABLED) {
            CompileServerManager.instance(project).configureWidget()
            CompileServerLauncher.instance.init(project)
          }
        } else {
          CompileServerLauncher.instance.stop()
          CompileServerManager.instance(project).removeWidget()
        }
      }

      true
    }
  })

  def getComponentName = getClass.getSimpleName

  def initComponent() {}

  def disposeComponent() {}

  def projectOpened() {}

  def projectClosed() {}
}