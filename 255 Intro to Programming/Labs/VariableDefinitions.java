public class VariableDefinitions {
	public static void main(String args[]) {
		//initial declaration of priceItem variable
		double priceItem = 32.32;
		//initial declaration of classroomNum variable
		int classroomNum = 207;
		//initial declaration of numPets variable
		byte numPets = 2;
		//initial declaration of longNum variable
		long longNum = 990123456789L;

		System.out.println("The priceItem variable has a value of " + priceItem);
		System.out.println("The classroomNum variable has a value of " + classroomNum);
		System.out.println("The numPets variable has a value of " + numPets);
		System.out.println("The longNum variable has a value of " + longNum);

		//modified value of priceItem variable
		priceItem = 23.23;
		//modified value of classroomNum variable
		classroomNum = 210;
		//modified value of numPets variable
		numPets = 3;
		//modified value of longNum variable
		longNum = 990987654321L;

		System.out.println("The priceItem variable now has a value of " + priceItem);
		System.out.println("The classroomNum variable now has a value of " + classroomNum);
		System.out.println("The numPets variable now has a value of " + numPets);
		System.out.println("The longNum variable now has a value of " + longNum);

		//initial declaration of pi constant
		final double PI = 3.14159;
		//initial declaration of random_num constant
		final int RANDOM_NUM = 409;
		//initial declaration of rainbow_colors constant
		final byte RAINBOW_COLORS = 7;
		//initial declaration of my_first_intial constant
		final short NUM_STUDENTS = 21;

		//double PI = 3.3;

		System.out.println("The PI variable now has a value of " + PI);
		System.out.println("The RANDOM_NUM variable now has a value of " + RANDOM_NUM);
		System.out.println("The RAINBOW_COLORS variable now has a value of " + RAINBOW_COLORS);
		System.out.println("The NUM_STUDENTS variable now has a value of " + NUM_STUDENTS);
	}
}