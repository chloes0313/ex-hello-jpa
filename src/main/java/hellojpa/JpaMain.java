package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager ();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Address address = new Address("city","street","zipcode");
            Address address2 = new Address(address.getCity(), address.getStreet(), address.getZipcode());;

            Member member = new Member();
            member.setUsername("Chloe");
            member.setHomeAddress(new Address("city","street","zipcode"));
            member.setWorkPeriod(new Period());

            em.persist(member);
            int a = 10;
            int b = 10;

            String aa = "new";
            String bb = aa;

            System.out.println(a == b);
            System.out.println(address == address2);
            System.out.println(address.equals(address2));
            System.out.println(aa == bb);
            System.out.println(aa.equals(bb));

            System.out.println("============================");
//            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void logic(Member fm1, Member fm2) {
        //실제객체가 넘어오는지 프록시로 넘어오는지 알 수 없음
        //System.out.println("fm1.class == fm2.class : " + (fm1.getClass() == fm2.getClass()));
        System.out.println("fm1 instanceof Member : " + (fm1 instanceof Member));
        System.out.println("fm2 instanceof Member : " + (fm2 instanceof Member));
    }

    private static void printMember (Member member) {
        System.out.println("member = " + member.getUsername());
    }

}
