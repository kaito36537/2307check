package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entity.WeightEntity;
import com.example.demo.Repository.WeightRepository;

@Controller
@RequestMapping("/weights")
@Validated
public class WeightController {
    
    @Autowired
    private WeightRepository weightRepository;
    
    // 一覧画面の表示
    @GetMapping
    public String showWeightList(Model model) {
        model.addAttribute("weights", weightRepository.findAll());
        return "index"; // index.htmlを表示する
    }

    // 新規入力フォームの表示
    @GetMapping("/new")
    public String showNewWeightForm(Model model) {
        model.addAttribute("weight", new WeightEntity());
        return "form"; // form.htmlを表示する
    }

    // 新規入力データの保存
    @PostMapping("/save")
    public String saveWeight(@ModelAttribute("weight") @Validated WeightEntity weight, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // エラーがある場合、入力フォームを再表示
            return "form";
        }

        weightRepository.save(weight);
        return "redirect:/weights"; // 一覧画面にリダイレクト
    }


    // 編集フォームの表示
    @GetMapping("/edit/{id}")
    public String showEditWeightForm(@PathVariable Long id, Model model) {
        WeightEntity weight = weightRepository.findById(id).orElse(null);
        model.addAttribute("weight", weight);
        return "edit"; // form.htmlを表示する
    }

    // 編集データの保存
    @PostMapping("/edit/{id}")
    public String updateWeight(@PathVariable Long id, @ModelAttribute("weight") WeightEntity weightData) {
        WeightEntity weight = weightRepository.findById(id).orElse(null);
        if (weight != null) {
            weight.setName(weightData.getName());
            weight.setWeight(weightData.getWeight());
            weightRepository.save(weight);
        }
        return "redirect:/weights"; // 一覧画面にリダイレクト
    }
    

    // データの削除
    @PostMapping("/delete/{id}")
    public String deleteWeight(@PathVariable Long id) {
        weightRepository.deleteById(id);
        return "redirect:/weights"; // 一覧画面にリダイレクト
    }

}

