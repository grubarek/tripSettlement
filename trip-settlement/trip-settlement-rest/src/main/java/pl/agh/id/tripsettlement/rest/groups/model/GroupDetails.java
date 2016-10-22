package pl.agh.id.tripsettlement.rest.groups.model;

/**
 * Created by pawel on 22.10.16.
 */

import java.util.List;

/**
 * Klasa reprezentuje dane wyściowe z podsumowaniem ile kto ma zapłacić.
 */
public class GroupDetails {
    private Long groupId;
    private Double summaryCost;
    private List<UserResumeDTO> users;

    public GroupDetails() {
    }

    @Override
    public String toString() {
        return "GroupDetails{" +
                "groupId=" + groupId +
                ", summaryCost=" + summaryCost +
                ", users=" + users +
                '}';
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Double getSummaryCost() {
        return summaryCost;
    }

    public void setSummaryCost(Double summaryCost) {
        this.summaryCost = summaryCost;
    }

    public List<UserResumeDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserResumeDTO> users) {
        this.users = users;
    }
}
