package Users.Roles;

import java.util.ArrayList;
import java.util.List;

import Users.Permissions.*;

public interface Role {
    List<Permissions> permissions = new ArrayList<>();

}
