package com.wolkenapps.testappforspringfortc;

import totalcross.ui.Button;
import totalcross.ui.Container;
import totalcross.ui.Control;
import totalcross.ui.MainWindow;
import totalcross.ui.event.ControlEvent;
import totalcross.ui.event.PressListener;

import com.wolkenapps.vernum.context.ApplicationContext;
import com.wolkenapps.vernum.context.DefaultApplicationContext;
import com.wolkenapps.vernum.context.stereotypes.InitializingBean;
import com.wolkenapps.vernum.factory.config.BeanDefinition;
import com.wolkenapps.vernum.factory.config.BeansDefinitions;

public class ApplicationToTestVernum extends MainWindow {

    public void initUI() {
        ApplicationContext context = ApplicationContext.Current.set(new DefaultApplicationContext());
        context.append(new BeansDefinitions() {
            public BeanDefinition[] get(ApplicationContext context) {
                return new BeanDefinition[] {
                        new BeanDefinition("main-container", BeanDefinition.SCOPE_PROTOTYPE, MainContainer.class),
                        new BeanDefinition("login-container", BeanDefinition.SCOPE_PROTOTYPE, LoginContainer.class),
                };
            }
        });
        context.start();

        add((Control) context.getBean("main-container"), LEFT, TOP, FILL, FILL);

    }

    public void onExit() {
        ApplicationContext.Current.get().stop();
        super.onExit();
    }

    public static final class MainContainer extends Container implements InitializingBean {

        public void initUI() {
            Button btn = new Button("Login!");
            add(btn, CENTER, CENTER);

            btn.addPressListener(new PressListener() {
                public void controlPressed(ControlEvent arg0) {
                    LoginContainer login = (LoginContainer) ApplicationContext.Current.get().getBean("login-container");
                    MainWindow.getTopMost().swap(login);
                }
            });

        }

        public void afterPropertiesSet() {
            
        }
    }

    public static final class LoginContainer extends Container {
        public void initUI() {

            add(new Button("Logout!"), CENTER, CENTER);

        }
    }

}
