public class Application {

	public static void main(String[] args) {
		CreateAccount ca=new CreateAccount();
		WithDraw wd=new WithDraw();
		Deposit d=new Deposit();
		BalanceVerify b=new BalanceVerify();
		
		Scanner sc=new Scanner(System.in);
		//int id;
		//System.out.println("Enter the id no: ");
		//id=sc.nextInt();

		
		try {
			wd.getBalance(00001);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

