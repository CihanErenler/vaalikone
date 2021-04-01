package data;

public class Candidate 
{
	private int id;
	private String fname;
	private String lname;
	private String city;
	private String age;
	private String profession;
	private String politicalParty;
	private String whyCandidate;
	private String about;
	private String profilePic;
	
	public Candidate(String id, String fname, String lname, String city, String age,
			String profession, String politicalParty, String whyCandidate,
			String about, String profilePic) 
	{
		setId(id);
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.age = age;
		this.profession = profession;
		this.politicalParty = politicalParty;
		this.whyCandidate = whyCandidate;
		this.about = about;
		this.profilePic = profilePic;
	}
	
	public Candidate() 
	{
		
	}
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public void setId(String id) 
	{
		try 
		{
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) 
		{
			
		}
	}
	
	public String getFname() 
	{
		return fname;
	}
	public void setFname(String fname) 
	{
		this.fname = fname;
	}
	
	public String getLname() 
	{
		return lname;
	}
	public void setLname(String lname) 
	{
		this.lname = lname;
	}
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public String getAge() 
	{
		return age;
	}
	public void setAge(String age) 
	{
		this.age = age;
	}
	public String getProfession() 
	{
		return profession;
	}
	public void setProfession(String profession) 
	{
		this.profession = profession;
	}
	public String getPoliticalParty() 
	{
		return politicalParty;
	}
	public void setPoliticalParty(String politicalParty) 
	{
		this.politicalParty = politicalParty;
	}
	public String getWhyCandidate() 
	{
		return whyCandidate;
	}
	public void setWhyCandidate(String whyCandidate) 
	{
		this.whyCandidate = whyCandidate;
	}
	public String getAbout() 
	{
		return about;
	}
	public void setAbout(String about) 
	{
		this.about = about;
	}
	public String getProfilePic() 
	{
		return profilePic;
	}
	public void setProfilePic(String profilePic) 
	{
		this.profilePic = profilePic;
	}
	

}
