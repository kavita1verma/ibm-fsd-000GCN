package comm.living;

public class Dog implements LivingThings {
	public String name,breed;
	public Dog(String nm,String brd) {
		this.name = nm;
		this.breed = brd;
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getBreed() {
		return breed;
	}



	public void setBreed(String breed) {
		this.breed = breed;
	}



	@Override
	public void walk() {
		
	}
	
	public void createLivingThings() {
		LivingThings livingThings = new LivingThings() {

			@Override
			public void walk() {
				System.out.println("Dog Name: "+getName()+" Dog Breed: "+getBreed()+" can also walk");
			}
		};
			livingThings.walk();
	}
}

