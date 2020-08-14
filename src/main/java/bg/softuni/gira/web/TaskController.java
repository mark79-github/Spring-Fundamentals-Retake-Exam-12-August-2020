package bg.softuni.gira.web;

import bg.softuni.gira.model.bind.TaskAddBindingModel;
import bg.softuni.gira.model.entity.enumerated.Progress;
import bg.softuni.gira.model.service.TaskServiceModel;
import bg.softuni.gira.model.service.UserServiceModel;
import bg.softuni.gira.service.ClassificationService;
import bg.softuni.gira.service.TaskService;
import bg.softuni.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;
    private final ClassificationService classificationService;
    private final UserService userService;

    @Autowired
    public TaskController(TaskService taskService, ModelMapper modelMapper, ClassificationService classificationService, UserService userService) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.classificationService = classificationService;
        this.userService = userService;
    }

    @GetMapping("/add")
    public String add(Model model) {

        if (!model.containsAttribute("taskAddBindingModel")) {
            model.addAttribute("taskAddBindingModel", new TaskAddBindingModel());
        }

        return "add-task";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid
                             @ModelAttribute(name = "taskAddBindingModel") TaskAddBindingModel taskAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);
            return "redirect:/task/add";
        }

        UserServiceModel userServiceModel = this.userService.getUserByEmail(httpSession.getAttribute("user").toString());

        TaskServiceModel taskServiceModel = this.modelMapper.map(taskAddBindingModel, TaskServiceModel.class);
        taskServiceModel.setClassification(this.classificationService.getClassificationByName(taskAddBindingModel.getClassification()));
        taskServiceModel.setProgress(Progress.OPEN);
        taskServiceModel.setUser(userServiceModel);

        this.taskService.addTask(taskServiceModel);

        return "redirect:/home";
    }

    @PostMapping("/{id}")
    public String progressConfirm(@PathVariable(name = "id") String id) {

        TaskServiceModel taskServiceModel = this.taskService.getTaskById(id);

        if (taskServiceModel == null) {
            return "redirect:/home";
        }

        this.taskService.editProgress(taskServiceModel);

        return "redirect:/home";
    }
}
