//http://den.sh/quasiquotes.html
import language.experimental.macros
import scala.reflect.macros.whitebox.Context

object MyIntMacro {
  def apply(x: Int): Any = macro impl
  def impl(c: Context)(x: c.Tree): c.Expr[Any] = {
    import c.universe._
    c.Expr[Int](q"x + 1")
  }
}

object Test {
  /*start*/MyIntMacro(2)/*end*/
}
//Int