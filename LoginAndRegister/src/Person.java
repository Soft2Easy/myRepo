import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Person implements IPerson
{
	//this are the user details
	private String username;
	private String password;
	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

   /*
    * This Method adds the non-existing users to the database(text files)
    */
	@Override
	public boolean Register()
	{
		try 
		{
			
			if(CompareUsers(getUsername()) == false)
			{
				FileWriter register =new FileWriter("User_File.txt",true);
				BufferedWriter bw =new BufferedWriter(register);
				bw.write(getUsername()+" "+getPassword());
				bw.newLine();
				bw.flush();
				bw.close();
				System.out.println("User is successfully registered");
				return true;
			}else
			{
				System.out.println("User already exists in the system");
				return false;
			}
			
	
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	/*
	 * This Method read all the users from the files so that they can be used 
	 * for comparison purposes
	 * @returns list of all the users
	 */
	@Override
	public ArrayList<String> getUsers() 
	{
		File readBase =new File("User_File.txt");
		ArrayList<String> list =new ArrayList<String>();
		try 
		{
			
			FileReader scanFile = new FileReader(readBase);
			BufferedReader br = new BufferedReader(scanFile);
			
				String read_line = br.readLine();
				
				while(read_line !=null)
				{
					list.add(read_line);
					read_line = br.readLine();
				}
				
			
			br.close();
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/*
	 * This Method compare the current user from the already existing users in the database
	 * @user is the user's user-name
	 * @returns the boolean
	 */
	
	@Override
	public boolean CompareUsers(String user) 
	{
		boolean checker = false;
		for(String recieve:getUsers())
		{
			String[] name =recieve.split(" ");
			String user_name =name[0];
			
			if(user_name.equalsIgnoreCase(user))
			{
				checker =true;
				break;
			}
			
		}
		
		return checker;
	}

	/*
	 * This Method checks if both of the user details are corrects and
	 * @return a boolean to indicate whether user details are correct
	 */
	@Override
	public boolean Login() 
	{
		if((CompareUsers(getUsername()) && ComparePasswords(getPassword())) == true)
		{
			System.out.println("User is successfuly logged in");
			return true;
		}else
		{
			System.out.println("Username or password incorrect");
			return false;
		}
		
	}

	/*
	 * This Method compare the current user's password from the already existing user passwords in the database
	 * @password is the user's password
	 * @returns the boolean
	 */
	@Override
	public boolean ComparePasswords(String password) 
	{
		boolean checker = false;
		for(String recieve:getUsers())
		{
			String[] name =recieve.split(" ");
			String user_name =name[1];
			
			
			
			if(user_name.equals(password))
			{
				checker =true;
				break;
			}
			
		}
		
		return checker;
	}

}
