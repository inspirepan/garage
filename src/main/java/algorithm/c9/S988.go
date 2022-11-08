func smallestFromLeaf(root *TreeNode) string {
	if root == nil {
		return ""
	}
	var res string
	var dfs func(root *TreeNode, str string)
	dfs = func(root *TreeNode, str string) {
		//当前字符串
		str = string('a'+root.Val) + str
		//终止条件 叶子节点，跟当前res存储值比较
		if root.Left == nil && root.Right == nil {
			if res == "" {
				res = str
				return
			}
			if res > str {
				res = str
				return
			}
		}
		if root.Left != nil {
			dfs(root.Left, str)
		}
		if root.Right != nil {
			dfs(root.Right, str)
		}
	}
	dfs(root, "")
	return res
}