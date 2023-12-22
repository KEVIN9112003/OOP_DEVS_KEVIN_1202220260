public class User {
   
   
   // TO DO: Create Private Attributes of User (nama, noHandphone)
   public String Nama;
   public String Nohandphone;
   
   // TO DO: Create Constructor of User
   public User(String Nama,String Nohandphone){
      this.Nama=Nama;
      this.Nohandphone=Nohandphone;
   }
   
   public void setName(String nama) {
      System.out.println("Masukan Nama"+ Nama);
         
      }

   public void setNoHandPhone(String phoneNumber) {
      System.out.println("Masukan nohandphone:"+ Nohandphone);
      }
   // TO DO: Create register Method to show information about name and phone number
   public void register(){
      System.out.println("silahkan Register");
        
    }
   // TO DO: Create method to return name and phone number
   
   public String getName() {
      System.out.println("masukan Nama" + Nama);
      return Nama;
     
  }

   public String getnoHandPhone() {
      System.out.println("Masukan no Handphone"+ Nohandphone);
      return Nama;
     
  }
}






  