public class MyBool{
	public static boolean not(boolean b){
		if (b){
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean and(boolean b, boolean c){
		if(b){
			if (c){
				return true;
			}
			else{
				return false;
			}
		}
		else {
			return false;
		}
	}

	public static boolean or(boolean b, boolean c){
		if (b){
			return true;
		}
		else if (c){
			return true;
		}
		else {
			return false;
		}
		
	}

	public static void main(String[] args){
		boolean f = false;
		boolean t = true;
		System.out.println(not(t));
		System.out.println(not(f));

		System.out.println(and(t, t));
		System.out.println(and(t, f));
		System.out.println(and(f, t));
		System.out.println(and(f, f));

		System.out.println(or(t, t));
		System.out.println(or(t, f));
		System.out.println(or(f, t));
		System.out.println(or(f, f));
	}
}
