package web;

import dao.DaoFactory;
import dao.imp.MovieDaoImpl;
import dto.*;
import model.Movie;
import model.Ticket;
import service.api.Service;
import service.impl.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class WebApp {
    public static void main(String[] args) {
        LocalDate sd = LocalDate.of(1994,03, 25);
        LocalDate fd = LocalDate.now();
        Time lt1 = new Time(12,50,1);
        Time lt2 = new Time(20,20,0);
        Time lt3 = new Time(9,30,0);
//        String thor = "Тору предстоит сразиться за спасение Земли и Девяти Миров от таинственного врага из времен, предшествовавших возникновению вселенной. После событий «Тора» и «Мстителей» главный герой борется за восстановление порядка в космосе, но древняя раса во главе с мстительным Малекитом возвращается, чтобы погрузить вселенную обратно во тьму. Столкнувшись с врагом, которому не способен противостоять ни Один, ни весь Асгард, Тор отправляется в самое рискованное путешествие, которое воссоединит его с Джейн Фостер с Земли и заставит пожертвовать всем ради спасения вселенной.";
//        String hulk = "После неудачного эксперимента с гамма-лучами учёный Брюс Беннер мутирует, превращаясь при гневе в зелёного монстра — Халка. Брюс скрывается от армии США, которая считает его своей собственностью. Он прячется в бразильских фавелах, постоянно проверяя свой пульс, чтобы он не достиг критического. Однажды он совершает ошибку, и генерал Росс выходит на его след, посылая отряд майора Блонски.";
//        String gifted = "Фрэнк Адлер живет в прибрежном городке во Флориде и воспитывает в одиночку свою необычайно одаренную племянницу Мэри. Но планы парня о спокойной школьной жизни для девочки рушатся, когда о математических способностях ребенка узнает грозная мать Фрэнка Эвелин. У бабушки свои представления о будущем внучки, и ради этого она готова даже разлучить Мэри с Фрэнком.";
//        String shutterIsland = "Два американских судебных пристава отправляются на один из островов в штате Массачусетс, чтобы расследовать исчезновение пациентки клиники для умалишенных преступников. При проведении расследования им придется столкнуться с паутиной лжи, обрушившимся ураганом и смертельным бунтом обитателей клиники.";
        Service<Integer, MovieDTO> moviService = MovieServiceImpl.getInstance();
//        MovieDTO movieDTO = new MovieDTO("Тор","боевик, приключения, фэнтези", thor,120,sd,fd,"thor", "<iframe width=\"420\" height=\"260\" src=\"https://www.youtube.com/embed/y00d5f5qmIs\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>");
//        MovieDTO movieDTO2 = new MovieDTO("Невероятный Халк","боевик, приключения, фэнтези", hulk,120,sd,fd,"hulk","<iframe width=\"420\" height=\"260\" src=\"https://www.youtube.com/embed/P6zUFiyXnIg\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>");
//        MovieDTO movieDTO3 = new MovieDTO("Одаренная","семейная драма", gifted,120,sd,fd,"gifted", "<iframe width=\"420\" height=\"260\" src=\"https://www.youtube.com/embed/Xu-VOKDUMe8\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>");
//        MovieDTO movieDTO4 = new MovieDTO("Остров проклятых","триллер, драмма, детектив", shutterIsland,120, sd, fd,"shutterIsland", "<iframe width=\"420\" height=\"260\" src=\"https://www.youtube.com/embed/hZXgJVChNQc\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>");
//        movieDTO.setId(1);
//        movieDTO2.setId(2);
//        movieDTO3.setId(3);
//        movieDTO4.setId(4);
//        MovieDTO updateMovieDTO = new MovieDTO("!!!!!!!!","!!!!!!!!!!","d",1,sd,fd,"p","t");
//        movieDTO.setId(1);

//        System.out.println(moviService.getBy("title","title"));
//        for (MovieDTO dto : moviService.getAllBy("title","t")) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        moviService.save(movieDTO);
//        moviService.save(movieDTO2);
//        moviService.save(movieDTO3);
//        moviService.save(movieDTO4);
//        for (MovieDTO dto : moviService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        System.out.println("get by ID:");
//        System.out.println(moviService.getById(2).toString());
//        moviService.update(movieDTO);
//        moviService.update(movieDTO2);
//        moviService.update(movieDTO3);
//        moviService.update(movieDTO4);
//        System.out.println("after update :");
//
//        for (MovieDTO dto : moviService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        System.out.println("after delete :");
//        moviService.delete(9);
//        moviService.delete(10);
//        moviService.delete(11);
//        moviService.delete(12);
//        for (MovieDTO dto : moviService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//  --------------------------------------------------------------------------------------------------------------------
        Service<Integer, HallDTO> hallService = HallServiceImpl.getInstance();
//        HallDTO hallDTO = new HallDTO("Blue","BlueHall",10,100);
//        hallDTO.setId(1);
//        HallDTO updateHallDTO = new HallDTO("!!!!!!!!","!!!!!!!!!!!",1,10);
//        updateHallDTO.setId(4);
//
//        hallService.save(hallDTO);
//        for (HallDTO dto : hallService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        System.out.println("get by ID:");
//        System.out.println(hallService.getById(2).toString());
//        hallService.update(hallDTO);
//        System.out.println("after update :");
//
//        for (HallDTO dto : hallService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        System.out.println("after delete :");
//        hallService.delete(1);
//        for (HallDTO dto : hallService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//  --------------------------------------------------------------------------------------------------------------------
//        Service<Integer, RoleDTO> roleService = RoleServiceImpl.getInstance();
//        RoleDTO roleDTO = new RoleDTO("User");
//        RoleDTO roleDTO2 = new RoleDTO("Admin");
//        RoleDTO updateRoleDTO = new RoleDTO("n");
//        updateRoleDTO.setId(3);
//        roleService.save(roleDTO);
//        for (RoleDTO dto : roleService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        System.out.println("get by ID:");
//        System.out.println(roleService.getById(2).toString());
//        roleService.update(updateRoleDTO);
//        System.out.println("after update :");
//
//        for (RoleDTO dto : roleService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        System.out.println("after delete :");
//        roleService.delete(2);

//        for (RoleDTO dto : roleService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//  --------------------------------------------------------------------------------------------------------------------
        Service<Integer, SessionDTO> sessionService = SessionServiceImpl.getInstance();
        SessionDTO sessionDTO = new SessionDTO(lt1,100, moviService.getById(1), hallService.getById(1));
//        sessionDTO.setId(1);
        SessionDTO sessionDTO2 = new SessionDTO(lt2,150, moviService.getById(1), hallService.getById(2));
//        sessionDTO2.setId(2);
        SessionDTO sessionDTO3 = new SessionDTO(lt3,100, moviService.getById(2), hallService.getById(1));
//        sessionDTO3.setId(3);
        SessionDTO sessionDTO4 = new SessionDTO(lt1,150, moviService.getById(2), hallService.getById(2));
//        sessionDTO4.setId(4);
        SessionDTO sessionDTO5 = new SessionDTO(lt2,100, moviService.getById(3), hallService.getById(1));
//        sessionDTO5.setId(5);
        SessionDTO sessionDTO6 = new SessionDTO(lt3,150, moviService.getById(3), hallService.getById(2));
//        sessionDTO6.setId(6);

        SessionDTO sessionDTO7 = new SessionDTO(lt1,100, moviService.getById(4), hallService.getById(1));
        SessionDTO sessionDTO8 = new SessionDTO(lt3,150, moviService.getById(4), hallService.getById(2));

//        SessionDTO updateSessionDTO = new SessionDTO(sd, updateMovieDTO, updateHallDTO);
//        updateSessionDTO.setId(3);
//
//        sessionService.save(sessionDTO);
//        sessionService.save(sessionDTO2);
//        sessionService.save(sessionDTO3);
//        sessionService.save(sessionDTO4);
//        sessionService.save(sessionDTO5);
//        sessionService.save(sessionDTO6);
//        sessionService.save(sessionDTO7);
//        sessionService.save(sessionDTO8);


//        for (SessionDTO dto : sessionService.getAllBy("movieId", "2")) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        System.out.println("get by ID:");
//        System.out.println(sessionService.getById(3).toString());
//        sessionService.update(sessionDTO);
//        sessionService.update(sessionDTO2);
//        sessionService.update(sessionDTO3);
//        sessionService.update(sessionDTO4);
//        sessionService.update(sessionDTO5);
//        sessionService.update(sessionDTO6);
//        System.out.println("after update :");
//
//        for (SessionDTO dto : sessionService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        System.out.println("after delete :");
//        sessionService.delete(1);
//        for (SessionDTO dto : sessionService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//  --------------------------------------------------------------------------------------------------------------------
        Service<Integer, TicketDTO> ticketService = TicketServiceImpl.getInstance();
//        TicketDTO ticketDTO = new TicketDTO(sessionService.getById(1),100);
//        ticketDTO.setId(1);
//        TicketDTO ticketDTO2 = new TicketDTO(sessionService.getById(2),150);
//        ticketDTO2.setId(2);
//        TicketDTO ticketDTO3 = new TicketDTO(sessionService.getById(3),100);
//        TicketDTO ticketDTO4 = new TicketDTO(sessionService.getById(4),150);
//        TicketDTO ticketDTO5 = new TicketDTO(sessionService.getById(5),100);
//        TicketDTO ticketDTO6 = new TicketDTO(sessionService.getById(6),150);
//        TicketDTO ticketDTO7 = new TicketDTO(sessionService.getById(7),100);
//        TicketDTO ticketDTO8 = new TicketDTO(sessionService.getById(8),150);

//        ticketDTO.setId(1);
//        TicketDTO updateTicketDTO = new TicketDTO(updateSessionDTO,1);
//        updateTicketDTO.setId(2);

//        ticketService.save(ticketDTO3);
//        ticketService.save(ticketDTO4);
//        ticketService.save(ticketDTO5);
//        ticketService.save(ticketDTO6);
//        ticketService.save(ticketDTO7);
//        ticketService.save(ticketDTO8);
//        for (TicketDTO dto : ticketService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        System.out.println("get by ID:");
//        System.out.println(ticketService.getById(2).toString());
//        ticketService.update(ticketDTO);
//        ticketService.update(ticketDTO2);
//       System.out.println("after update :");
//
//        for (TicketDTO dto : ticketService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//       }
//        for (TicketDTO ticketDTO : ticketService.getAllBy("sessionId", String.valueOf(1))) {
//            System.out.println(ticketDTO);
//        }
//        System.out.println("after delete :");
//        ticketService.delete(1);
//        ticketService.delete(2);
//        ticketService.delete(3);
//        ticketService.delete(4);
//        ticketService.delete(5);
//        ticketService.delete(6);
//        ticketService.delete(7);
//        ticketService.delete(8);
//        ticketService.delete(9);
//        for (TicketDTO dto : ticketService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//  --------------------------------------------------------------------------------------------------------------------

//        Service<Integer, UserDTO> userService = UserServiceImpl.getInstance();
//        UserDTO userDTO = new UserDTO("root", "root", "Artem", "Tereshchuk", "email@gmail.com","mail", sd, roleService.getBy("name","Admin"));
//        UserDTO updateUserDTO = new UserDTO("l", "p", "f", "l", "e","s", sd, updateRoleDTO);
//        updateUserDTO.setId(2);


//       userService.save(userDTO);
//        for (UserDTO dto : userService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        System.out.println("get by ID:");
//        System.out.println(userService.getById(2).toString());
//        userService.update(updateUserDTO);
//        System.out.println("after update :");

//        for (UserDTO dto : userService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }
//        System.out.println("after delete :");
//        userService.delete(2);
//        for (UserDTO dto : userService.getAll()) {
//            System.out.println(dto.toString() + " Id : " + dto.getId());
//        }



    }
}
