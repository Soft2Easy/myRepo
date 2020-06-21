import java.util.ArrayList;

public interface IPerson
{
   boolean Register();
   ArrayList<String> getUsers();
   boolean CompareUsers(String user);
   boolean ComparePasswords(String password);
   boolean Login();
}
