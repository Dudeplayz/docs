package com.vaadin.demo.component.popover;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.demo.DemoExporter; // hidden-source-line
import com.vaadin.demo.domain.DataService;
import com.vaadin.demo.domain.Person;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.popover.Popover;
import com.vaadin.flow.component.popover.PopoverPosition;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.Route;

@Route("popover-anchored-dialog")
public class PopoverAnchoredDialog extends Div {

    public PopoverAnchoredDialog() {
        Grid<Person> grid = new Grid<>(Person.class, false);
        grid.addColumn(Person::getFirstName).setKey("firstName")
                .setHeader("First name");
        grid.addColumn(Person::getLastName).setKey("lastName")
                .setHeader("Last name");
        grid.addColumn(Person::getEmail).setKey("email").setHeader("Email");
        grid.addColumn(person -> person.getAddress().getPhone()).setKey("phone")
                .setHeader("Phone");
        grid.addColumn(new LocalDateRenderer<>(
                PopoverAnchoredDialog::getPersonBirthday, "yyyy-MM-dd"))
                .setKey("birthday").setHeader("Birthday");
        grid.addColumn(Person::getProfession).setKey("profession")
                .setHeader("Profession");

        grid.setItems(DataService.getPeople());

        Span title = new Span("Employees");
        title.getStyle().set("font-weight", "bold");

        Button button = new Button(VaadinIcon.GRID_H.create());
        button.addThemeVariants(ButtonVariant.LUMO_ICON);
        button.setAriaLabel("Show / hide columns");

        HorizontalLayout headerLayout = new HorizontalLayout(title, button);
        headerLayout.setAlignItems(FlexComponent.Alignment.BASELINE);
        headerLayout.setFlexGrow(1, title);

        // tag::snippet[]
        Popover popover = new Popover();
        popover.setModal(true);
        popover.setBackdropVisible(true);
        popover.setPosition(PopoverPosition.BOTTOM_END);
        popover.setTarget(button);

        H4 heading = new H4("Configure columns");
        heading.getStyle().set("margin", "0");

        List<String> columns = List.of("firstName", "lastName", "email",
                "phone", "birthday", "profession");

        CheckboxGroup<String> group = new CheckboxGroup<>();
        group.addThemeVariants(CheckboxGroupVariant.LUMO_VERTICAL);
        group.setItems(columns);
        group.setItemLabelGenerator((item) -> {
            String label = StringUtils
                    .join(StringUtils.splitByCharacterTypeCamelCase(item), " ");
            return StringUtils.capitalize(label.toLowerCase());
        });
        group.addValueChangeListener((e) -> {
            columns.stream().forEach((key) -> {
                grid.getColumnByKey(key).setVisible(e.getValue().contains(key));
            });
        });

        Set<String> defaultColumns = Set.of("firstName", "lastName", "email",
                "profession");
        group.setValue(defaultColumns);

        Button showAll = new Button("Show all", (e) -> {
            group.setValue(new HashSet<String>(columns));
        });

        Button reset = new Button("Reset", (e) -> {
            group.setValue(defaultColumns);
        });

        HorizontalLayout footer = new HorizontalLayout(showAll, reset);
        footer.setSpacing(false);
        footer.getThemeList().add("spacing-xs");

        popover.add(heading, group, footer);
        // end::snippet[]

        add(headerLayout, grid, popover);
    }

    private static LocalDate getPersonBirthday(Person person) {
        return person.getBirthday().toInstant().atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static class Exporter extends DemoExporter<PopoverAnchoredDialog> { // hidden-source-line
    } // hidden-source-line
}
