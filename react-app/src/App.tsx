import {ProductList} from "./ProductList.tsx";
import {QueryClient, QueryClientProvider} from "@tanstack/react-query";

const queryClient = new QueryClient({
    defaultOptions: {
        queries: {
            retry: false,
            refetchOnWindowFocus: false,
            gcTime: 0
        }
    }
})

function App() {

  return (
    <>
    <QueryClientProvider client={queryClient}>

        <div>
            <h1>Shopping cart app</h1>
            <ProductList/>
        </div>
    </QueryClientProvider>

    </>
  )
}

export default App
