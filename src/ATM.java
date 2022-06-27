import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username = "mralibatu", password = "4044";
        String gusername = null,gpassword = null;
        int choose;
        int right = 3, balance = 1200;

        while(true){
            System.out.println("Kullanici adini giriniz : ");
            gusername = input.next();
            System.out.println("Sifrenizi giriniz : ");
            gpassword = input.next();

            if (gusername.equals(username) && gpassword.equals(password)){
                System.out.println("Hosgeldiniz!");
                do{
                    System.out.println("1-Para Yatirma\n" +
                            "2-Para Cekme\n" + "3-Bakiye Sorgula\n"+
                            "4 Cikis Yap");
                    System.out.println("Lutfen yapmak istediginiz islemi tuslayiniz : ");

                    choose = input.nextInt();
                    switch (choose){
                        case 1:
                            System.out.println("Yatirilacak miktari giriniz : ");
                            int yatirilanpara = input.nextInt();
                            if(yatirilanpara < 0){
                                System.out.println("Hatali giris yaptiniz, ana menuye yonlendiriliyorsunuz..");
                                choose = 4;
                            } else {
                                System.out.println(yatirilanpara + "TL yatirilacak onayliyor musunuz?");
                                int onay = input.nextInt();
                                switch (onay){
                                    case 1:
                                        balance += yatirilanpara;
                                        System.out.println("Basariyla yatirildi, yeni bakiyeniz : " + balance + "\n" + "Cikis yapiliyor..");
                                        break;
                                    default:
                                        System.out.println("İslem iptal edildi, cikis yapiliyor...");
                                        choose = 4;
                                        break;
                            }

                            }
                            break;
                        case 2:
                            System.out.println("Cekmek istediginiz miktari giriniz : ");
                            int cekilecekpara = input.nextInt();
                            if (cekilecekpara > balance){
                                System.out.println("Bakiye yetersiz, tekrar deneyiniz");
                                choose = 2;
                            }else{
                                balance -= cekilecekpara;
                                System.out.println("Islem basariyla gerceklestirildi, yeni bakiyeniz : " + balance);
                            }
                            break;
                        case 3:
                            System.out.println("Bakiyeniz : " + balance);
                        case 4:
                            System.out.println("Iyi gunler dileriz.");
                            break;
                        default:
                            System.out.println("Hatali tuslama yaptiniz, tekrar deneyiniz");
                    }


                }while(choose > 4);
            } else{
                right--;
                System.out.println("Bilgiler yanlis girildi, tekrar denemeniniz için ana ekrana yönlendiriliyorsunuz..");
                System.out.println("Kalan hakkiniz : " + right);
            }

            if(right <= 0){
                System.out.println("Giris hakkiniz kalmadi");
                break;
            }
        }

    }
}
