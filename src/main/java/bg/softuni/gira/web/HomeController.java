package bg.softuni.gira.web;

import bg.softuni.gira.model.service.TaskServiceModel;
import bg.softuni.gira.model.view.TaskViewModel;
import bg.softuni.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model,
                       HttpSession httpSession) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (!model.containsAttribute("tasks")) {
            List<TaskServiceModel> taskServiceModels = this.taskService.getAllTasks();
            List<TaskViewModel> tasks = taskServiceModels.stream()
                    .map(taskServiceModel -> {
                        TaskViewModel taskViewModel = this.modelMapper.map(taskServiceModel, TaskViewModel.class);
                        taskViewModel.setClassification(taskServiceModel.getClassification().getClassificationName().toString());
                        taskViewModel.setUser(taskServiceModel.getUser().getUsername());
                        return taskViewModel;
                    }).collect(Collectors.toList());
            model.addAttribute("tasks", tasks);
        }

        return "home";
    }
}
