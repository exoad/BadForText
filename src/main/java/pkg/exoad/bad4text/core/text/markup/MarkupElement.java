package pkg.exoad.bad4text.core.text.markup;
import pkg.exoad.bad4text.core.structs.Pair;
import pkg.exoad.bad4text.core.structs.TreeNode;

import java.util.ArrayList;
public class MarkupElement
{
	public final String tag;
	public final ArrayList< String > appliedTags;

	public MarkupElement(String tag)
	{
		this.tag = tag;
		this.appliedTags = new ArrayList<>();
	}

	public MarkupElement(String tag, ArrayList< String > appliedTags)
	{
		this.tag = tag;
		this.appliedTags = appliedTags;
	}

	public static ArrayList< MarkupElement > extractTags(
			TreeNode< Pair< String, String > > node, ArrayList< String > parentTags
	)
	{
		ArrayList< MarkupElement > elementsWithTags = new ArrayList<>();

		if (node != null)
		{
			ArrayList< String > elementTags = new ArrayList<>(parentTags);
			if (node.tag.first != null && !node.tag.first.startsWith(MarkupLexer.TAG_CLOSE))
				elementTags.add(node.tag.first);

			TreeNode< Pair< String, String > > child = node.children;
			while (child != null)
			{
				elementsWithTags.addAll(extractTags(
						child,
						elementTags
				));
				child = child.children;
			}

			if (!elementTags.isEmpty())
				elementsWithTags.add(new MarkupElement(
						node.tag.second,
						elementTags
				));
		}

		return elementsWithTags;
	}
}
