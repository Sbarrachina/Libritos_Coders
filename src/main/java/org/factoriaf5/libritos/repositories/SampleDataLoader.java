package org.factoriaf5.libritos.repositories;

import org.factoriaf5.libritos.repositories.Book;
import org.factoriaf5.libritos.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SampleDataLoader {

    private BookRepository bookRepository;

    @Autowired
    public SampleDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void loadSampleData() {
        bookRepository.saveAll(List.of(
                new Book("Noelia",29,"Garcia Abanto","España","Pais Vasco","universitaria","Inspira BlB","https://media-exp1.licdn.com/dms/image/D4D03AQFR9WDbvl9E0A/profile-displayphoto-shrink_800_800/0/1640071645345?e=1646870400&v=beta&t=ru_YTmmFdgkQsnBqhouEVnVV8rL6SCkFWDaYdcckLag"),
                new Book("Leo", 26,"De León","España","Barcelona","Educación secundaria obligatoria","Inspira BLB","https://media-exp1.licdn.com/dms/image/C5603AQG2q9Kqg8xQeg/profile-displayphoto-shrink_800_800/0/1631266617227?e=1646870400&v=beta&t=ZrNmbAUagF6IeS7q7HtVHi9CU27AnyAZ80eENEH_a14"),
                new Book("Inga", 31,"Demetrashvili","Georgia","Barcelona","Universitaria", "inspira","https://media-exp1.licdn.com/dms/image/C5603AQFrmqKrckcKNw/profile-displayphoto-shrink_800_800/0/1630571173844?e=1646870400&v=beta&t=Zhub6JrY1dG54_AU3FGhS9k5dTJMBcZs-Bduwo3s-1A"),
                new Book("Maria Alexandra", 38,"Galarza","España","Barcelona","Post Grado Universitario" ,"Inspira","https://media-exp1.licdn.com/dms/image/C4E03AQEk4Sq4qVgReQ/profile-displayphoto-shrink_800_800/0/1628002727064?e=1646870400&v=beta&t=1-fVyCOR-WbbhMNErPO7svyzfAZLUHBcJad-VezRBGA"),
                new Book("Paola",25,"Gonzalez","España","Badalona","Diplomatura","Factoria5","https://media-exp1.licdn.com/dms/image/C4E03AQFSoqjGkQTRsw/profile-displayphoto-shrink_800_800/0/1582895670078?e=1646870400&v=beta&t=zoXP0O7ta3y0bST7glHaXJWSuLP0GADNxkne3--QVXc"),
                new Book("Maria ",30,"Valverde","España","Gijón","Grado Superior","Ast","https://media-exp1.licdn.com/dms/image/C4D03AQEg37AeOcLOwg/profile-displayphoto-shrink_800_800/0/1609343897545?e=1646870400&v=beta&t=vKJRnwXm8_aEFpCKOsRO45-fy7HVpHjWUahtFgfELd0")
        ));
    }
}
