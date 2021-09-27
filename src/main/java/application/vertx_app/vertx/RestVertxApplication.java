package application.vertx_app.vertx;

import adapter.controller.UserController;
import application.vertx_app.vertx.controller.VertxUserController;
import com.fasterxml.jackson.annotation.JsonInclude;
import config.VertxConfig;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Launcher;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class RestVertxApplication extends AbstractVerticle {

	private final VertxConfig vertxConfig = new VertxConfig();
	private final UserController userController = new UserController(vertxConfig.createUser(), vertxConfig.findUser(), vertxConfig.loginUser());
	private final VertxUserController controller = new VertxUserController(userController);

	@Override
	public void start() {
//		Json.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//		Router router = Router.router(vertx);
//		router.route().handler(BodyHandler.create());
//		router.post("/users").handler(controller::createUser);
//		router.get("/login").handler(controller::login);
//		router.get("/users/:userId").handler(controller::findUser);
//		router.get("/users").handler(controller::findAllUser);
//
//		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
	}

	public static void main(final String[] args) {
		Launcher.executeCommand("run", RestVertxApplication.class.getName());
	}
}
