package org.jetbrains.plugins.scala.lang.parser;

import com.intellij.lang.PsiParser;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * User: Dmitry.Krasilschikov
 * Date: 02.10.2006
 * Time: 13:18:27
 */
public class ScalaParser extends PsiParser {

    @NotNull
    public ASTNode parse(IElementType root, PsiBuilder builder) {
        PROGRAM.parse(builder);
        return builder.getTreeBuilt();
    }
}
