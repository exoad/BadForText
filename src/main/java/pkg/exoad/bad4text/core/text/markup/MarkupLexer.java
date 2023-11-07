package pkg.exoad.bad4text.core.text.markup;
import pkg.exoad.bad4text.core.structs.Pair;
import pkg.exoad.bad4text.core.structs.TreeNode;

import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Attempts to recreate an XML and HTML like markup language.
 *
 * @author Jack Meng
 */
public class MarkupLexer
{
	/// TODO: Fix this shit, it doesnt work and can't pair nested tags which is annoying to fix based on the current treenode structuring.
	///       It is so fucking stupid in terms of how the treenode handles all of its pairing when backed by a stack.
	public static final String TAG_START = "<";
	public static final String TAG_END = ">";
	public static final String TAG_CLOSE = "/";
	public static final TreeNode< Pair< String, String > > DEFAULT_ROOT_NODE = new TreeNode<>(Pair.make(
			"_ROOT_",
			null
	));
	public static final Pattern TAG_PATTERN = Pattern.compile(TAG_START + "(\\w+?)" + TAG_END +
			                                                          "(.*?)" + TAG_START + TAG_CLOSE + "\\1"
			                                                          + TAG_END);

	public static TreeNode< Pair< String, String > > lex(String string)
	{
		Matcher matcher = TAG_PATTERN.matcher(string);
		TreeNode< Pair< String, String > > root = new TreeNode<>(Pair.make(
				"_ROOT_",
				null
		));
		TreeNode< Pair< String, String > > currentNode = root;
		Stack< TreeNode< Pair< String, String > > > stack = new Stack<>();

		while (matcher.find())
		{
			String tagName = matcher.group(1);
			String tagContent = matcher.group(2);

			TreeNode< Pair< String, String > > newTag = new TreeNode<>(Pair.make(
					tagName,
					tagContent
			));
			if (currentNode.children == null)
				currentNode.children = newTag;
			else
			{
				TreeNode< Pair< String, String > > sibling = currentNode.children;
				while (sibling.children != null)
					sibling = sibling.children;
				sibling.children = newTag;
			}
		}
		return root;
	}

	public static void calcTagDepth(
			TreeNode< Pair< String, String > > node, int depth, HashMap< String, Integer > tagDepths
	)
	{
		tagDepths.put(
				node.tag.first,
				depth
		);
		TreeNode< Pair< String, String > > child = node.children;
		while (child != null)
		{
			calcTagDepth(
					child,
					depth + 1,
					tagDepths
			);
			child = child.children;
		}
	}

	public static HashMap< String, Integer > calcTagDepth(TreeNode< Pair< String, String > > node)
	{
		HashMap< String, Integer > tagDepth = new HashMap<>();
		calcTagDepth(
				node,
				0,
				tagDepth
		);
		return tagDepth;
	}

	public static String formatLexedHierarchy(TreeNode< Pair< String, String > > node, int depth)
	{
		StringBuilder result = new StringBuilder();
		result.append("  ".repeat(Math.max(
				0,
				depth
		)));
		result.append(TAG_START)
		      .append(node.tag.first)
		      .append(TAG_END)
		      .append("\n");
		if (node.tag.second != null)
		{
			String[] lines = node.tag.second.trim()
			                                .split("\n");
			for (String line : lines)
			{
				result.append("  ".repeat(Math.max(
						0,
						depth + 1
				)));
				result.append(line)
				      .append("\n");
			}
		}
		TreeNode< Pair< String, String > > child = node.children;
		while (child != null)
		{
			result.append(formatLexedHierarchy(
					child,
					depth + 1
			));
			child = child.children;
		}
		for (int i = 0; depth > 0 && i < depth; i++)
			result.append("  ");
		result.append(TAG_START)
		      .append(TAG_CLOSE)
		      .append(node.tag.first)
		      .append(TAG_END)
		      .append("\n");
		return result.toString();
	}
}
