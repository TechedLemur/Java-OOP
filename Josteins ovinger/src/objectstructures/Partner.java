package objectstructures;

public class Partner {
	
	String name;
	Partner partner;
	
	public Partner(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Partner getPartner() {
		return this.partner;
	}
	
	public void deletePartner() {
		this.partner = null;
	}
	
	public void setPartner(Partner partner) {
		if (partner == null) {
			this.partner.deletePartner();
			this.partner = null;
			
			return;
			
		}
		
		if(this.partner != null && partner.getPartner() != null && 
				this.partner != partner && partner.getPartner() != this) {
		
			partner.setPartner(null);
			setPartner(null);
			setPartner(partner);
			return;
		}
		
		
		
		if (this.partner != partner) {
			this.partner = partner;
		}
		
		if(partner.getPartner() != this)
			partner.setPartner(this);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
