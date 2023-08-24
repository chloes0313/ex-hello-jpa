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

            Parent parent = new Parent();

            Child child1 = new Child();
            Child child2 = new Child();

            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            em.remove(findParent);

//            em.persist(child1);
//            em.persist(child2);

            System.out.println("============================");
            tx.commit();
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
    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }
}
