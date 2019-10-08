package me.mazeika.validity.util;

/**
 * Holds general-purpose validation checks.
 */
public final class Validation
{
    /**
     * Requires that the given boolean expression is true, otherwise throws
     * an {@link IllegalArgumentException}.
     *
     * @param message the message to throw
     * @param expression the expression to check
     */
    public static void requireThat(String message, boolean expression)
    {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }
}
