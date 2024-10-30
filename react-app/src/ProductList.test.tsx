import {describe, it, expect, beforeEach} from "vitest";
import {render, screen} from "@testing-library/react";
import {ProductList} from "./ProductList.tsx";
import {QueryClient, QueryClientProvider} from "@tanstack/react-query";

const queryClient = new QueryClient({
    defaultOptions: {
        queries: {
            retry: false,
            networkMode: "always"
        },
    },
});

beforeEach(() => {
    const originalFetch = globalThis.fetch;
    globalThis.fetch = async (input: any, init: any) => {
        const url = new URL(input.toString(), 'http://localhost:8080');
        return originalFetch(url.toString(), init);
    };
});

describe("Product list page", () => {
    it("Should show a list of products including an apple watch", async () => {

        render(
            <QueryClientProvider client={queryClient}>
                <ProductList/>
            </QueryClientProvider>
        )
            const watch= await screen.findByText("Apple Watch");
            expect(watch).toBeDefined();
    })
})
