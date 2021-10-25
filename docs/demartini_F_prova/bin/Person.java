// Class Declaration

public class Person
{
	// Instance Variables
	String name = " ";
	String surname = " ";
	int age = 0;
	String sex = " ";

	// Constructor Declaration of Class
	public Person(String name, String surname,
				int age, String sex)
	{
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.sex = sex;
	}

	// method 1
	public String getName()
	{
		return name;
	}

	// method 2
	public String getSurname()
	{
		return surname;
	}

	// method 3
	public int getAge()
	{
		return age;
	}

	// method 4
	public String getSex()
	{
		return sex;
	}

	@Override
	public String toString()
	{
		return(	"name "+ this.getName()+
				"\nsurname "+ this.getSurname()+
				"\nage "+ this.getAge()+
				"\ncolor "+ this.getSex() );
	}

	
	public static void main(String[] args)
	{
		Person p1 = new Person("Bil","Gates",50,"male");
		System.out.println(p1.toString());
		
	}
}