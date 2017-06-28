import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Collections {
	
	public static void main(String args[])
	{
		Set<String> s=new HashSet();
		s.add("hi");
		s.add("bye");
		s.add("hi");
		/*for(int i=0;i<s.size();i++)
		{
			System.out.println("The value is"+s.);
		}
*/		Iterator<String> iterator=s.iterator();
		while(iterator.hasNext())
		{
			System.out.println("The val is "+iterator.next());
		}
	}

}
