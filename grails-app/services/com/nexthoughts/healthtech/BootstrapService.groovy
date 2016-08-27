package com.nexthoughts.healthtech

import com.healthtech.Role
import com.healthtech.User
import com.healthtech.UserRole
import com.healthtech.AppUtil
import grails.transaction.Transactional
import healthtech.Author

@Transactional
class BootstrapService {
    List<String> listOfNames = ["Hans", "Shantay", "Jaunita", "Natosha", "Philip", "Lora", "Zoraida", "Letha", "Palmira", "Cindi", "Yvone", "Dolores", "Evette", "Mauricio", "Kimberlie", "Renata", "Inge", "Shemika", "Krista", "Alethia", "Imogene", "Shondra", "Margeret", "Eun", "Rosaura", "Ellsworth", "Lavina", "Lucila", "Shizue", "Lamonica", "Casey", "Calista", "Caterina", "Becki", "Jae", "Miguelina", "Pamila", "Pricilla", "Faith", "Andria", "Carolyne", "Alicia", "Quiana", "Gay", "Kathern", "Soledad", "Deb", "Ahmed", "Micki", "Hassie", "Selena", "Abram", "Tawana", "Frieda", "Lakeshia", "Arletha", "Nikita", "Tomoko", "Melania", "Kristin", "Rhett", "Ester", "Cherise", "Burl", "Nilda", "Emilee", "Jules", "Hortense", "Jami", "Rodney", "Pablo", "Ardelia", "Meggan", "Allyson", "Evangelina", "Erinn", "Porfirio", "Galen", "Cathern", "Melany", "Avelina", "Yevette", "Rosia", "Shaquana", "Jacquelyn", "Torrie", "Angela", "Lavera", "Taylor", "Mariann", "Debra", "Cristine", "Dan", "Stan", "Leonida", "Harriette", "Christia", "Leonie", "Cris", "Velvet", "Cyndy", "Rosalyn", "Mia", "Garry", "Elda", "In", "Shani", "Nevada", "Windy", "Monica", "Maile", "Angila", "Tabitha", "Clemmie", "Sylvester", "Gary", "Nichelle", "Conchita", "Lorrie", "Berta", "Bev", "Casey", "Faustino", "Luetta", "Doretha", "Angelique", "Zenobia", "Britta", "Alita", "Aleida", "Ramona", "Simone", "Cathrine", "Dagny", "Etta", "Reynaldo", "Ariel", "Timothy", "Kenton", "Victor", "Jude", "Kristofer", "Prudence", "Stacey", "Fred", "Vicenta", "Grace", "Teisha", "Leroy", "Leta"]
    Random random = new Random()

    String getRandomName() {
        int index = Math.abs(random.nextInt() % 150) + 1
        if (listOfNames[index]) {
            return listOfNames[index]
        } else {
            return null
        }
    }


    void createAdmin() {
        if (User.count() == 0) {
            User admin = new User(username: "ali@nexthoughts.com", password: "admin212").save(flush: true)

            Role role = new Role(authority: "ROLE_ADMIN").save(flush: true)

            UserRole.create(admin, role, true)
        }
    }

    Boolean createAuthors() {
        if (Author.count == 0) {

            String firstName
            String lastName

            999.times {
                firstName = getRandomName() ?: 'Ziddane'
                lastName = getRandomName() ?: 'Hadid'
                Author author = new Author(firstName: firstName, lastName: lastName)
                AppUtil.save(author)
            }

        }
        true
    }

}
