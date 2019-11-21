package visit;

public class NamedEntity implements INamedEntity {
	private String name;

	public NamedEntity() {
		name = "none";
	}
	
	/* (non-Javadoc)
	 * @see src.visit.INamedEntity#getName()
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
