package org.jetbrains.plugins.scala
package lang.typeInference.generated

import org.jetbrains.plugins.scala.lang.typeInference.TypeInferenceTestBase

/**
 * @author kfeodorov 
 * @since 02.04.14.
 */
class TypeInferenceMacrosTest extends TypeInferenceTestBase {
  //This class was generated by build script, please don't change this
  override def folderPath: String = super.folderPath + "macros/"

//  def testSimple() {doTest()}
//  def testImplicitParameter() {doTest()}
  def testMacroAsImplicitParameter() {doTest()}
//  def testMacroIsImplicit() {doTest()}
}