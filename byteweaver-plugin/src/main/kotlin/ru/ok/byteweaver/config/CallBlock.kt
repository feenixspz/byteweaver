package ru.ok.byteweaver.config

class CallBlock(
        val isStatic: Boolean,
        val declaringClassPattern: DeclaringClassPattern,
        val methodName: LiteralName,
        val descPattern: MethodDescPattern,
        val operations: List<Operation>,
) {
    override fun toString() = buildString {
        append(descPattern.returnTypePattern).append(" ").append(declaringClassPattern).append('.').append(methodName)
        append('(')
        var first = true
        for (parameterTypePattern in descPattern.parameterTypePatterns) {
            if (!first) {
                append(", ")
            } else {
                first = false
            }
            append(parameterTypePattern)
        }
        if (descPattern.hasThreeStarsPattern) {
            if (!first) {
                append(", ")
            }
            append("***")
        }
        append(')')
        if (operations.isNotEmpty()) {
            append(" { ... }")
        } else {
            append(';')
        }
    }
}
