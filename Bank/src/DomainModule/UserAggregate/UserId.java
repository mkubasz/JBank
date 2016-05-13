package DomainModule.UserAggregate;

import DomainModule.IValueOfObject;

import java.util.UUID;

/**
 * Created by mkuba on 12.05.2016.
 */
public class UserId implements IValueOfObject {
    private UUID id;
    public UserId(UUID uuid) {
        id = uuid;
    }
}
