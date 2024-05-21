prod: 
	docker compose -f docker-compose.yml up -d
test:
	docker compose -f docker-compose-test.yml up -d
dev:
	docker compose -f docker-compose-dev.yml up -d
