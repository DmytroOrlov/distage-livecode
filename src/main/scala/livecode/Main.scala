package livecode

import izumi.distage.plugins.load.PluginLoader.PluginConfig
import izumi.distage.roles.{BootstrapConfig, RoleAppLauncher, RoleAppMain}
import izumi.fundamentals.platform.cli.model.raw.RawRoleParams
import livecode.code.LivecodeRole
import zio.Task
import zio.interop.catz._

object Main
  extends RoleAppMain.Default[Task](
    launcher = new RoleAppLauncher.LauncherF[Task] {
      override val bootstrapConfig = BootstrapConfig(
        PluginConfig(
          debug            = false,
          packagesEnabled  = Seq("livecode.plugins"),
          packagesDisabled = Nil,
        )
      )
    }
  ) {
  override val requiredRoles: Vector[RawRoleParams] = {
    Vector(RawRoleParams.empty(LivecodeRole.id))
  }
}
