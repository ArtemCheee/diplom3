package UserData;

import com.github.javafaker.Faker;


    public class ClientData {

        static Faker user = new Faker();

        public static String generateRandomEmail() {
            return user.regexify("[a-zA-Z]{5,10}") + System.currentTimeMillis() + "@ya.ru";
        }

        public static String generateRandomPassword() {
            return user.regexify("[A-Za-z0-9]{8}");
        }

        public static String generateRandomName() {
            return user.regexify("[A-Za-z]{8}");

        }

        public static String generateWrongRandomPassword() {
            return user.regexify("[0-9]{2}");
        }

        public static ClientModel generateRandomUser() {
            return new ClientModel(
                    generateRandomName(),
                    generateRandomEmail(),
                    generateRandomPassword()
            );
        }

    }
