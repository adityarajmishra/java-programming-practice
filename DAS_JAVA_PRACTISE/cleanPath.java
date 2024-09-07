import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String path = sc.nextLine();

        System.out.println(cleanPath(path));

    }
    public static String cleanPath(String path){
		//write your code here
        Deque<String> stack = new LinkedList<>();
        String[] components = path.split("/");

        for (String part : components) {
            if (part.equals("") || part.equals(".")) {
                // Skip empty and '.' components
                continue;
            } else if (part.equals("..")) {
                // Pop from the stack if it's not empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory name, push onto the stack
                stack.push(part);
            }
        }

        // If stack is empty, return root "/"
        if (stack.isEmpty()) {
            return "/";
        }

        // Build the result path from the stack
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.insert(0, "/" + dir);  // Add each directory to the front
        }

        return result.toString();
    }
}


The task is to simplify a given Unix-style file path, handling various scenarios such as resolving "." for the current directory, ".." for moving up one directory, and collapsing multiple consecutive slashes.

Here’s how to approach this problem:

Use a Stack: We can break down the path into its components using / as the delimiter. Then, we process each part:

If the part is . or empty (due to consecutive slashes), we skip it.
If the part is .., we pop from the stack (if possible) to move one directory up.
Otherwise, the part is a valid directory or file, so we push it onto the stack.
Rebuild the Simplified Path: After processing all parts, the stack contains the simplified path. We join the elements with / and ensure the result starts with /.

Explanation:
Splitting: The path is split by / to get the individual components.
Processing Components:
Ignore empty parts or . (current directory).
For .., pop the last added directory from the stack if available.
Otherwise, push the component onto the stack (it’s a valid directory or file).
Rebuild the Path: Finally, the stack contains the valid path components, which are joined to form the simplified path.


Key Changes:
Path Construction:

We iterate over the stack to construct the path by adding each directory to the front of the StringBuilder. This preserves the directory order and ensures that the path is correctly formed.
Simplified Stack Usage:

We now iterate through the stack once to build the result, avoiding issues with ordering.
Why This Fix Works:
The key issue was how the directories were being added to the path. By explicitly adding them in the correct order using insert(0, "/" + dir), we maintain the expected order.
Expected Output:
The output should now match the expected behavior:

Input: /home/user/Documents/../Pictures
Expected Output: /home/user/Pictures
Input: /home//foo/
Expected Output: /home/foo
Please try this updated approach, and let me know if it resolves the test case failures.