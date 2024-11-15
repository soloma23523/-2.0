public class ValidatorOne {
   public boolean isValid(String phoneNumber){
       // проверяем, что телефон начинается с символа "+" и далее содержит только цифры
       return phoneNumber != null && phoneNumber.matches("//+//d+");
   }
}
