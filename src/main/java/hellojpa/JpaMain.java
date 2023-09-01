package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager ();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("Chloe");
            member.setHomeAddress(new Address("homeCity","homeStreet","00000"));
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("국물닭발");

            AddressEntity address1 = new AddressEntity("oldCity1", "oldStreet1", "10000");
            AddressEntity address2 = new AddressEntity("oldCity2", "oldStreet2", "10001");
            member.getAddressHistory().add(address1);
            member.getAddressHistory().add(address2);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());
            //address_history 수정
//            findMember.getAddressHistory().remove(new AddressEntity("oldCity1", "oldStreet1", "10000"));
//            findMember.getAddressHistory().add(new AddressEntity("newCity1", "newStreet1", "10000"));
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

}
