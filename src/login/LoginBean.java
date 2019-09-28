package login;

import java.io.Serializable;

public class LoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private String username;
	private String FName;
	private String LName;
   

	private String password;
    private int isAdmin; // zero if the user is admin , 1 if the user is student

    public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

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
    
    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	 public String getFName() {
			return FName;
		}

		public void setFName(String fName) {
			FName = fName;
		}

		public String getLName() {
			return LName;
		}

		public void setLName(String lName) {
			LName = lName;
		}
}
