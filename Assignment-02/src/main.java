public class main {
	
	public static void main(String[] args) {

		Map<String, Integer> map = new Map<>();
		
		map.add("Haris", 1);
		map.add("51379", 2);
		map.add("Sir Suffyan", 4);
		map.add("Data Structure & Algorithm", 5);

		System.out.println("\nMap Size : " + map.size());
		
		System.out.println("\nRemoving : " + map.remove("Sir Suffyan"));
		System.out.println("\nRemoving : " + map.remove("Data Structure & Algorithm"));

		System.out.println("\nMap Size : " + map.size());
		System.out.println("\nMap isEmpty : " + map.isEmpty());
	}	
}
