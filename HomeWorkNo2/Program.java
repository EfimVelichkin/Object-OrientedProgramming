package org.example;
/*1)Создайте три класса: Человек, Кот, Робот, которые не наследуются от одного класса. Эти классы должны уметь бегать и прыгать, все также с выводом информации о действии в консоль.
2) Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
печатаем в консоль (успешно пробежал, не смог пробежать и т.д.). У препятствий есть длина
(для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
3) Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
этот набор препятствий. Если участник не смог пройти одно из препятствий, то дальше по
списку он препятствий не идет.*/
public class Program {
    public static void main(String[] args) {
        Robot robot = new Robot(300, 6);
        Cat cat = new Cat(80, 4);
        Human human = new Human(100, 0);

        Treadmill treadmill = new Treadmill(50);
        Wall wall = new Wall(4);

        Object[] participants = {robot, human, cat};
        Object[] obstacles = {treadmill, wall};

        for (Object participant : participants) {
            if (participant instanceof Human) {
                Human h = (Human) participant;
                for (Object obstacle : obstacles) {
                    if (obstacle instanceof Treadmill) {
                        treadmill = (Treadmill) obstacle;
                        if (h.maxRunLength >= treadmill.length) {
                            h.run();
                        }
                    } else if (obstacle instanceof Wall) {
                        wall = (Wall) obstacle;
                        if (h.maxJumpHeight >= wall.height) {
                            h.jump();
                        }
                    }
                }
            } else if (participant instanceof Cat) {
                Cat c = (Cat) participant;
                for (Object obstacle : obstacles) {
                    if (obstacle instanceof Treadmill) {
                        treadmill = (Treadmill) obstacle;
                        if (c.maxRunLength >= treadmill.length) {
                            c.run();
                        }
                    } else if (obstacle instanceof Wall) {
                        wall = (Wall) obstacle;
                        if (c.maxJumpHeight >= wall.height) {
                            c.jump();
                        }
                    }
                }
            } else if (participant instanceof Robot) {
                Robot r = (Robot) participant;
                for (Object obstacle : obstacles) {
                    if (obstacle instanceof Treadmill) {
                        treadmill = (Treadmill) obstacle;
                        if (r.maxRunLength >= treadmill.length) {
                            r.run();
                        }
                    } else if (obstacle instanceof Wall) {
                        wall = (Wall) obstacle;
                        if (r.maxJumpHeight >= wall.height) {
                            r.jump();
                        }
                    }
                }
            }
        }
    }
}
