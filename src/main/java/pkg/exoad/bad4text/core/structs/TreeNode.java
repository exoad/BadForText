package pkg.exoad.bad4text.core.structs;
public class TreeNode < T >
{
	public T tag;
	public TreeNode< T > parent;
	public TreeNode< T > children;

	public TreeNode(T tag)
	{
		this.tag = tag;
	}

	@Override public String toString()
	{
		return tag.toString();
	}

}
