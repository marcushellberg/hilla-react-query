import {useMutation, useQuery, useQueryClient} from "@tanstack/react-query";
import {TodoService} from "Frontend/generated/endpoints";
import {useForm} from "@hilla/react-form";
import TodoModel from "Frontend/generated/com/example/application/db/TodoModel";
import {TextField} from "@hilla/react-components/TextField";
import {Button} from "@hilla/react-components/Button";

export default function HelloWorldView() {

    // Access the client
    const queryClient = useQueryClient()

    // Queries
    const query = useQuery({ queryKey: ['todos'], queryFn: TodoService.getTodos })

    // Mutations
    const mutation = useMutation({
        mutationFn: TodoService.save,
        onSuccess: () => {
            // Invalidate and refetch
            queryClient.invalidateQueries({ queryKey: ['todos'] })
        },
    })

    const {model, field, submit} = useForm(TodoModel, {
        onSubmit: async todo => mutation.mutate(todo)
    })

    return (
        <div className="p-m">
            <h1>Hilla todo</h1>
            <div className="flex gap-m">
                <TextField {...field(model.task)} />
                <Button onClick={submit}>Add todo</Button>
            </div>

            <ul>
                {query.data?.map(todo => (
                    <li key={todo.id}>{todo.task}</li>
                ))}
            </ul>
        </div>
    )
}
