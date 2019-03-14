package seedu.address.model;

import seedu.address.model.person.Member;

public interface MemberModel {
    /**
     * Returns true if a member with the same identity as {@code member} exists in the restaurant book.
     */
    boolean hasMember(Member member);

    /**
     * Deletes the given member.
     * The member must exist in the restaurant book.
     */
    void deleteMember(Member target);
}
